package com.example.springvalidationtest.dto.request

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotEmpty

data class ReqMataPelajaran(

    @field:NotBlank(message = "Nama Mata Pelajaran tidak boleh kosong")
    @field:JsonProperty("nama_mata_pelajaran")
    var namaMataPelajaran: String,
)
