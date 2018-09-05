package com.mhdanh.javaee.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "post_detail")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class PostDetailEntity {

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private LocalDate dateCreated;

	@OneToOne
//	@JoinColumn(name = "post_id")
	@MapsId
	private PostEntity post;

}
