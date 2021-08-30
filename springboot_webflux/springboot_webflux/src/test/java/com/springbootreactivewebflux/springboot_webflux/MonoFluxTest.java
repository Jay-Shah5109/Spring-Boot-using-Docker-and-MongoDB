package com.springbootreactivewebflux.springboot_webflux;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Mono;

public class MonoFluxTest {
	
	@Test
	public void testMono(){
		
		Mono<?> monoobject=Mono.just("Jay").log();
		monoobject.subscribe(System.out::println);
	}

}
