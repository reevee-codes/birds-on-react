/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.borb.birby;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Greg Turnquist
 */
// tag::code[]
@Entity // <1>
public class Birb {

	private @Id @GeneratedValue Long id; // <2>
	private String firstName;
	private String color;
	private String description;

	private Birb() {}

	public Birb(String firstName, String color, String description) {
		this.firstName = firstName;
		this.color = color;
		this.description = description;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Birb birb = (Birb) o;
		return Objects.equals(id, birb.id) &&
			Objects.equals(firstName, birb.firstName) &&
			Objects.equals(color, birb.color) &&
			Objects.equals(description, birb.description);
	}

	@Override
	public int hashCode() {

		return Objects.hash(id, firstName, color, description);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Birb{" +
				"id=" + id +
				", firstName='" + firstName + '\'' +
				", color='" + color + '\'' +
				", description='" + description + '\'' +
				'}';
	}
}
// end::code[]
