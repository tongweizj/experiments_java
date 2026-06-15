package com.spring.vehicle;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Repository
public interface VehicleRepository extends ReactiveMongoRepository<Vehicle, String>  {

	Flux<Vehicle> findByYear(int year);

	Mono<Vehicle> findByVinNumber(String vinNumber);
    Mono<Void> deleteByVinNumber(String vinNumber);
    
	
}
