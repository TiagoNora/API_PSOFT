# Problem Statement

## 1- Objective
Design and Implement the service layer of a prototype REST service in Spring Boot with persistence via
ORM, i.e., JPA/Spring Data.
## 2- The Problem
**Product Reviews.**

ACME, Inc. needs a review system for its product catalogue so that users can author reviews and ratings
of items sold by ACME and help other users deciding what to buy. Products are characterized by a
designation and description as well as a set of images of the product and a SKU (Stock Keeping Unit).
ACME users can review an item providing a text with the review and a rating (0 to 5 stars, including half
stars). Reviews need to be approved by a moderator before being published. Other users can check the
review summary of an item (including the aggregated 5-star rating) as well as individual reviews. Users
can also vote for a review if they found it particularly helpful as well as report a review if they consider
such a review is offensive or somewhat misleading (e.g., self-promoting review).
Besides individual reviews and ratings, a product has an aggregated rating based on the weighted average
of all the ratings. Details of the aggregated rating is in the form of a frequency table (the frequency of
votes per star).

## 3- Use cases
3.1 Work Package #0 – setup
1. As admin, I want to “bootstrap” user credential data
2. As admin, I want to “bootstrap” product data

3.2 Work Package #1 - Products
1. As anonymous or registered customer I want to obtain the catalog of products.
2. As anonymous or registered customer I want to obtain the details of a product.
3. As anonymous or registered customer I want to search the catalog of products by product name
   or bar code.


3.3 Work Package #2 - Reviews
1. As registered customer I want to review and rate a product.
2. As anonymous or registered customer I want to obtain the reviews of a product. The return must
   be sorted in reverse chronological publishing date.
3. Augment the review with a funny fact about the date of publishing by using a public service, e.g.,
   http://numbersapi.com/9/21/date

3.4 Work Package #3 – Votes in Reviews
1. As registered customer I want to vote for a review
2. As registered customer I want to withdraw one of my reviews. Only possible if the review has no
   votes.
3. As anonymous or registered customer I want to obtain the reviews of a product, sorted by number
   of votes and reverse chronological publishing date.

3.5 Work Package #4 – Moderated Reviews
1. As system, I want all reviews to be created in a pending state requiring moderation
2. As moderator, I want to obtain all pending reviews
3. As moderator, I want to approve or reject a pending review
4. As registered customer I want to obtain all my reviews including their status.

3.6 Work Package #5 – Aggregated ratings
1. As anonymous or registered customer I want to obtain the aggregated rating of a product

3.7 Work Package #6 – Bonus
1. Product catalog and product search results should be paginated
2. Product details should include images, and it should be possible to obtain the product’s images
   and the SKU as a barcode image.
3. Product reviews should be paginated

## 4- User story acceptance criteria
   All user stories have the following acceptance criteria:
   * Analysis and design documentation
   * OpenAPI specification
   * POSTMAN collection with sample requests for all the use cases with tests.
   
## 5- Working mode
1. Each team will represent a company developing the solution to a customer.
2. The professor of Theoretical classes will work as the customer
3. The professor of the Lab classes will help the team in setting up the team environment and solve
   technical difficulties
4. Even though the assessment is individual, this is a joint project. From the customer’s perspective
   there is just one project and not individual projects (one from each student). As such the team
   mentality should be “one for all, all for one”, either you all win or you all loose. Nonetheless, to
   simplify the assessment of the work you may divide the work packages among team member’s in
   the following way:

    a. Work package 0 and 5 are the responsibility of the whole team

    b. Work packages 1, 2, 3 and 4 are the responsibility of one team member
   
    c. Note that, even if you are responsible for one work package you should help your team
   members in the other work packages if they are struggling with it. Remember, “one for
   all, all for one”
   
    d. Work package 6 represents optional features and are the responsibility of the whole team


5. The project development must follow the software engineering process as explained in ESOFT and
   as such, the team must:

    a. Work iteratively

    b. Analise the requirements and engage with the customer for clarifications (do not assume
      anything; always ask the customer what he really wants)

    c. Design the overall system architecture prior to starting the development
   
    d. For each use case,

    i. start by detailing the analysis and elaborate the design of the use case justifying
      your decisions

    ii. Implement the use case taking into consideration all the best practices learnt
      throughout the course (not just this course unit) and the acceptance criteria

    iii. Automate the test of the use case (e.g., junit, POSTMAN tests)

6. Third party libraries may be used freely but their use must be justified
7. Code extracts obtained from other sources (e.g., stack exchange) must be clearly marked thru
   comments in the code indicating its origin

## 6- Logistics
1. The assignment is to be made in groups of three or four students

2. PL classes will be devoted to help the students in carrying out the assignment.
3. Presentation and assessment of the assignment will be carried out in PL classes following the due
   date.
4. Delivery of the assignment will be done thru moodle in a single ZIP file (not RAR) with
   a. Analysis and design documentation
   b. Source code tarball
   c. Provide your self-assessment and peer assessment

## 7-  Assessment
   • Assessment will be done according to the criteria table in a scale of 0 to 4 (with one decimal place) for each criterion, then converted to a scale of 0 to 20.

   • Assessment grade may be given with one decimal place

   • Grades are individual, as such each student may have a different grade from the other group
   members
