package com.from28minutes.learnerAppendix.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionController {
	
	//URI Versioning
	@GetMapping("/v1/person")
	public PersonV1 getNameURIVersioning() {
		return new PersonV1("Indra Kumar");
	}
	
	@GetMapping("/v2/person")
	public PersonV2 getsecondNameURIVersioning() {
		return new PersonV2(new Name("Indra","Kumar"));
	}
	
	//Request Params Versioning
	@GetMapping(path = "/person", params = "version=1")
	public PersonV1 getNameparamsVersioning() {
		return new PersonV1("Indra Kumar");
	}
	
	@GetMapping(path = "/person", params = "version=2")
	public PersonV2 getsecondNameparamsVersioning() {
		return new PersonV2(new Name("Indra","Kumar"));
	}
	
	//Header Request Versioning
	@GetMapping(path = "/person/header", headers = "X-API-VERISON:1")
	public PersonV1 getNameHeaderVersioning() {
		return new PersonV1("Indra Kumar");
	}
	
	@GetMapping(path = "/person/header", headers = "X-API-VERISON:2")
	public PersonV2 getsecondNameHeadersVersioning() {
		return new PersonV2(new Name("Indra","Kumar"));
	}
	
		//content-negotiation Accept Request Versioning
		@GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v1+json")
		public PersonV1 getNameAcceptVersioning() {
			return new PersonV1("Indra Kumar");
		}
		
		@GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v2+json")
		public PersonV2 getsecondNameAcceptVersioning() {
			return new PersonV2(new Name("Indra","Kumar"));
		}
}



