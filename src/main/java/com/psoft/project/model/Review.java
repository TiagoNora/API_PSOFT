package com.psoft.project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.client.RestTemplate;

import javax.persistence.*;
import java.io.IOException;
import java.io.Serializable;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "reviews")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Review implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String status;
    @Column(nullable = true, columnDefinition = "TEXT")
    private String text;
    @Column(nullable = true)
    private float rating;

    @Column(nullable = true)
    private int totalVotes;

    @Column(nullable = true)
    private int upVotes;

    @Column(nullable = true)
    private int downVotes;
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDateTime;
    @Column(columnDefinition = "TEXT")
    private String funFact;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_sku", nullable = false)
    @JsonIgnore
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "review", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Vote> votes;

    public Review() {
    }

    public Review(String text, float rating) throws IOException {
        this.status = "PENDING";
        this.text = text;
        setRating(rating);
        Date dNow = new Date();
        LocalDate localDate = dNow.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int month = localDate.getMonthValue();
        int day = localDate.getDayOfMonth();
        retrieveDataFromApi(day,month);
        setCreationDateTime(dNow);
        this.totalVotes = 0;
        this.upVotes = 0;
        this.downVotes = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        if (rating > 5 || rating < 0) {
            throw new IllegalArgumentException("'rating' must be between 0 and 5 stars");
        }
        else if (rating % 0.5 != 0 ) {
            throw new IllegalArgumentException("'rating' can have 0.5 stars");
        }
        this.rating = rating;
    }

    public Date getCreationDateTime() {
        return creationDateTime;
    }

    public void setCreationDateTime(Date creationDateTime) {
        this.creationDateTime = creationDateTime;
    }

    public String getFunFact() {
        return funFact;
    }

    public void setFunFact(String funFact) {
        this.funFact = funFact;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void retrieveDataFromApi(int day, int month) throws IOException {
        String baseUrl = "http://www.numbersapi.com/";
        String url = baseUrl + month + "/" + day + "/date";

        try (CloseableHttpClient client = HttpClients.createDefault()) {

            HttpGet request = new HttpGet(url);

            CloseableHttpResponse response = client.execute(request);
            HttpEntity entity = response.getEntity();
            String result = EntityUtils.toString(entity);

            setFunFact(result);
        }
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }

    public int getTotalVotes() {
        return totalVotes;
    }

    public void setTotalVotes(int totalVotes) {
        this.totalVotes = totalVotes;
    }

    public int getUpVotes() {
        return upVotes;
    }

    public void setUpVotes(int upVotes) {
        this.upVotes = upVotes;
    }

    public int getDownVotes() {
        return downVotes;
    }

    public void setDownVotes(int downVotes) {
        this.downVotes = downVotes;
    }
}
