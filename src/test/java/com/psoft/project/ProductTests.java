package com.psoft.project;

import com.psoft.project.model.Product;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class ProductTests {

	@Test
	public void test_product_default_constructor() {
		Product product = new Product("asdfg12345qw","nome","Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...");
		assertEquals("asdfg12345qw", product.getSku());
		assertEquals("nome",product.getName());
		assertEquals("Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...", product.getDescription());
	}

	@Test
	public void test_product_default_constructor_invalid_sku_with_less_than_12_charaters() {
		assertThrows(IllegalArgumentException.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				Product product = new Product("asdfgh123","nome","Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...");
			}
		});
	}
	@Test
	public void test_product_default_constructor_invalid_sku_with_more_than_12_charaters() {
		assertThrows(IllegalArgumentException.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				Product product = new Product("asdfgh123dfghte1","nome","Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...");
			}
		});
	}

	@Test
	public void test_product_default_constructor_invalid_sku_with_nothing() {
		assertThrows(IllegalArgumentException.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				Product product = new Product("","nome","Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...");
			}
		});
	}
	@Test
	public void test_product_default_constructor_invalid_sku_with_no_alphanumeric_sku_just_numbers() {
		assertThrows(IllegalArgumentException.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				Product product = new Product("123456789012","nome","Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...");
			}
		});
	}
	@Test
	public void test_product_default_constructor_invalid_sku_with_no_alphanumeric_sku_just_letters() {
		assertThrows(IllegalArgumentException.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				Product product = new Product("qwertyuiopas","nome","Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...");
			}
		});
	}
	@Test
	public void test_product_default_constructor_invalid_name_no_name() {
		assertThrows(IllegalArgumentException.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				Product product = new Product("asdfg12345qw","","Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...");
			}
		});
	}
	@Test
	public void test_product_default_constructor_invalid_name_more_than_50_charaters() {
		assertThrows(IllegalArgumentException.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				Product product = new Product("asdfg12345qw","qwertyuiopasdfghjklçzxcvbnmqwertyuiopasdfghjklçzxcvbnm","Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...");
			}
		});
	}
	@Test
	public void test_product_default_constructor_invalid_descrition_no_description() {
		assertThrows(IllegalArgumentException.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				Product product = new Product("asdfg12345qw","qwertyuiopasdfghjklçzxcvbnmqwertyuiopasdfghjklçzxcvbnm","");
			}
		});
	}
	@Test
	public void test_product_default_constructor_invalid_descrition_more_than_1000_charaters() {
		assertThrows(IllegalArgumentException.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				Product product = new Product("asdfg12345qw","qwertyuiopasdfghjklçzxcvbnmqwertyuiopasdfghjklçzxcvbnm","\n" +
						"\n" +
						"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum vulputate porttitor leo at aliquet. Curabitur fringilla elit vel velit consequat, eu commodo massa tempus. Vestibulum nisi magna, consectetur vel varius sit amet, laoreet dictum velit. Quisque malesuada eleifend quam, eu consequat augue porta nec. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Etiam eget orci ac metus suscipit dictum. Sed volutpat pellentesque aliquet. Etiam quis risus vel urna faucibus malesuada. Proin efficitur lorem ac lorem aliquet pharetra. Phasellus tincidunt, metus vitae iaculis molestie, tortor ipsum dictum arcu, ac commodo sem tellus eget arcu. Aliquam iaculis sit amet odio id fermentum. Nam ut varius enim, a lacinia metus. Sed tincidunt fermentum eleifend. Mauris vitae vulputate sapien. Vivamus enim libero, sodales ac vestibulum eu, aliquet nec neque.\n" +
						"\n" +
						"Ut non accumsan ipsum. Curabitur rutrum interdum blandit. Proin lacinia sem nisi, vitae congue elit laoreet non. Proin eros leo, faucibus ac dui ac, sodales vestibulum tellus. Suspendisse nibh libero, sodales aliquet consectetur eget, finibus vel ante. Ut viverra ornare tempus. Donec in lacus sed metus facilisis efficitur et vitae nunc. Fusce lacinia turpis in risus finibus, sollicitudin dignissim risus varius. Etiam quis lacus mattis, scelerisque mi aliquet, auctor risus. Donec facilisis est quis tellus porta dictum in malesuada tortor. Integer sagittis luctus venenatis. Nullam at arcu turpis. Nunc sagittis urna sed dapibus semper. Sed varius felis hendrerit tellus lacinia aliquam.\n" +
						"\n" +
						"Praesent cursus eget risus in porttitor. Suspendisse in blandit justo. Nulla bibendum neque nulla, sit amet gravida felis posuere eu. Nullam eget gravida nunc. Nunc sagittis est arcu, sed sagittis magna accumsan in. Etiam luctus fermentum volutpat. Maecenas pulvinar velit id nibh placerat, ut facilisis ante pulvinar. Sed ullamcorper imperdiet neque in luctus. Aenean sapien erat, tempus nec ultrices in, aliquam non ante. Mauris sed aliquet dolor. Sed eget orci id ligula semper dapibus. Fusce a congue arcu. Fusce tincidunt ex sed egestas dapibus. Nullam aliquam ex id pretium mattis. Aenean magna purus, laoreet nec ex quis, imperdiet commodo nisi. Etiam at odio ornare, ultrices nulla a, congue ipsum.\n" +
						"\n" +
						"Praesent eu varius lectus. Ut vulputate libero vitae metus accumsan placerat. Aliquam aliquam tellus nibh, ac faucibus ipsum ultricies interdum. Curabitur ut rhoncus felis, ut feugiat nisi. Vestibulum pretium, sapien vel posuere finibus, nibh nunc maximus nulla, id iaculis sapien est a quam. Vestibulum placerat nec enim ac vestibulum. Nullam sed tortor porttitor, vehicula risus vitae, dictum odio. Pellentesque euismod varius urna, eu vulputate libero efficitur varius. Duis ullamcorper augue erat, quis congue eros vehicula cursus. Fusce dignissim id purus sed iaculis.\n" +
						"\n" +
						"Vivamus non ante at purus facilisis dignissim. Aliquam venenatis cursus elit et pharetra. Proin aliquet ullamcorper orci, fringilla laoreet dolor tincidunt eget. Praesent vel neque felis. Morbi mattis dapibus magna, id lacinia dui euismod condimentum. Morbi sed felis bibendum, tempus dui in, mollis nisl. Donec at neque dui. Nulla finibus, dui vitae bibendum maximus, felis dolor dapibus lacus, vitae cursus nisi enim at dolor. Nunc sodales vestibulum ante, sit amet tristique nibh facilisis at.\n" +
						"\n" +
						"Suspendisse eu vehicula sapien. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Nulla commodo, metus sed elementum porttitor, justo risus bibendum sem, hendrerit cursus ante sapien non libero. Vestibulum pulvinar arcu quis odio tristique fermentum. Aliquam tempus iaculis metus in egestas. Donec ut leo a velit interdum malesuada. Vestibulum quis ex neque. Ut a tortor imperdiet ex euismod bibendum vel a nisl.\n" +
						"\n" +
						"Nulla facilisi. In venenatis est ut luctus vehicula. Sed molestie risus vel fermentum blandit. Morbi rutrum iaculis purus, non efficitur lectus congue id. Cras quis nisl varius, commodo risus non, consectetur tortor. Proin eu volutpat libero, vitae sagittis est. Aliquam id tellus augue. Phasellus ac diam malesuada ligula cursus pretium. Aliquam ac dapibus tortor. Proin a justo et lorem venenatis vehicula ut sed sapien. Fusce nisl nisl, placerat at porta ut, congue tempor tortor. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Quisque in lectus ut turpis sagittis commodo.\n" +
						"\n" +
						"Suspendisse aliquet risus tortor, ut tincidunt purus sodales et. Cras sit amet lacinia nunc, sed sollicitudin risus. Vivamus ut vehicula nisi. Donec tortor nisl, interdum in ultricies nec, sollicitudin sit amet nisi. Suspendisse pretium felis felis, eu sagittis urna sagittis non. Phasellus non risus id nunc iaculis bibendum vitae sit amet felis. Aenean mattis odio eu arcu tincidunt bibendum. Donec semper erat sed tellus laoreet, quis faucibus urna eleifend. Mauris blandit fringilla enim, fringilla molestie massa. Aliquam erat volutpat. Nam imperdiet facilisis sapien ut congue.\n" +
						"\n" +
						"Nullam fringilla mauris quis ex efficitur, et consequat libero vehicula. Nunc blandit, risus tempus tristique auctor, ex massa interdum ante, vitae rutrum lectus nisi eu metus. Duis eget massa quis nunc consectetur varius vitae at odio. Nunc purus sapien, interdum non ligula a, molestie tempor enim. Suspendisse vel magna commodo, molestie tortor ac, porttitor mauris. Suspendisse iaculis hendrerit dui ac iaculis. Cras facilisis nisl eu aliquam scelerisque. Sed hendrerit tempus libero eget vulputate. Vestibulum laoreet sapien libero, et pretium dolor iaculis at. Phasellus nec turpis in nibh tincidunt molestie. Phasellus non elit eget ex maximus congue. Pellentesque eu neque a ex condimentum lobortis non sit amet diam. Ut posuere purus sodales lectus dignissim volutpat.\n" +
						"\n" +
						"Cras tempus sollicitudin ligula nec accumsan. Pellentesque et lacinia felis. Suspendisse sodales lorem at efficitur imperdiet. Duis sed egestas sem. Pellentesque et magna non lacus euismod tempor et ut odio. Etiam faucibus ligula sed molestie interdum. Cras sodales, massa vitae vestibulum posuere, turpis sapien tempor neque, nec euismod elit quam vel erat. Pellentesque varius eleifend tellus, quis pretium nunc convallis sit amet. Cras dictum posuere erat vitae semper. Proin tincidunt in sapien ac viverra.\n" +
						"\n" +
						"Quisque ac tempus turpis, egestas sollicitudin justo. Fusce iaculis felis ante, vel vehicula sem elementum a. Morbi facilisis fringilla elit, sed semper tortor varius quis. Cras vehicula sapien vitae tellus gravida, vitae ornare neque accumsan. Aliquam commodo magna vitae finibus tincidunt. Aenean scelerisque ut orci sit amet molestie. Nulla dignissim metus ut diam tincidunt commodo. In viverra enim augue, et placerat quam dapibus vitae. Donec accumsan venenatis purus, a venenatis leo efficitur. ");
			}
		});
	}

}
