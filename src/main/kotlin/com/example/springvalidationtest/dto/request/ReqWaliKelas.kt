package com.example.springvalidationtest.dto.request

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import org.springframework.format.annotation.NumberFormat

data class ReqWaliKelas(

    @field:NotNull
    @field:NotBlank(message = "Nama tidak boleh kosong")
    val nama: String?,

    @field:NotNull
    @field:NotBlank(message = "Jenis Kelamin tidak boleh kosong")
    @field:JsonProperty("jenis_kelamin")
    val jenisKelamin: String?,

    @field:NotNull
    @field:NumberFormat
    @field:JsonProperty("id_mata_pelajaran")
    val idMataPelajaran: Int?,
)
