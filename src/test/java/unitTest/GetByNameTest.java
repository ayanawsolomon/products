package unitTest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.pipelines.main.ProductRecord;
import com.pipelines.main.ProductService;


public class GetByNameTest {

	@Test
	public void test() {
		ProductService productServiceMock =  mock(ProductService.class);
		List<ProductRecord> products = new ArrayList();
		when(productServiceMock.getByID("11")).thenReturn(products);
		Assert.assertEquals(0, products.size());
		//fail("Not yet implemented");
	}
@Test
public void mockListSize() {
	List mockList= mock(List.class);
	when(mockList.size()).thenReturn(2).thenReturn(3);
	Assert.assertEquals(2, mockList.size());
	Assert.assertEquals(3, mockList.size());
}
}
