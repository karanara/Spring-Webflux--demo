package com.example.webflux.demo.springreactive.dao;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Component;
import com.example.webflux.demo.springreactive.Bean.Customer;

import reactor.core.publisher.Flux;
@Component
public class CustomerDao {

	private static void sleepExecution(int i) {
		try {
			Thread.sleep(1000);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public List<Customer> getCustomers(){
		return IntStream.rangeClosed(1, 10)
				.peek(CustomerDao::sleepExecution)
				.peek(i->System.out.println("processing number"+i))
				.mapToObj(i->new Customer(i,"customer " +i))
				.collect(Collectors.toList());
	}
	public Flux<Customer> getCustomersStream(){
		return Flux.range(1, 10)
				.delayElements(Duration.ofSeconds(1))
				.doOnNext(i->System.out.println("processing number" +i))
				.map(i->new Customer(i,"customer "+i));
	}
}
