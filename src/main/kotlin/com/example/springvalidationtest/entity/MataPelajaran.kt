package com.example.springvalidationtest.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.*

@Entity
@Table(name = "mata_pelajaran")
data class MataPelajaran(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id_mapel")
    val idMapel: Int? = null,

    @JsonProperty("nama_mata_pelajaran")
    var namaMataPelajaran: String?,

    @JsonIgnore
    @OneToMany(mappedBy = "mataPelajaran", cascade = [CascadeType.ALL], orphanRemoval = true)
    val waliKelas: List<WaliKelas>?
)
