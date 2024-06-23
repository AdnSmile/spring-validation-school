package com.example.springvalidationtest.dto.request

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import org.springframework.format.annotation.NumberFormat

data class ReqKelas(

    @field:NotNull
    @field:NotBlank(message = "Nama kelas tidak boleh kosong")
    @field:JsonProperty("nama_kelas")
    val namaKelas: String?,

    @field:NotNull
    @field:NumberFormat
    @field:JsonProperty("id_wali_kelas")
    val idWaliKelas: Int?,
)
