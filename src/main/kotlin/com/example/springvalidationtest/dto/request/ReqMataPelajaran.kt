package com.example.springvalidationtest.dto.request

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

data class ReqMataPelajaran(

    @field:NotBlank(message = "Nama Mata Pelajaran tidak boleh kosong")
    @field:NotNull
    @field:JsonProperty("nama_mata_pelajaran")
    val namaMataPelajaran: String?,
)
