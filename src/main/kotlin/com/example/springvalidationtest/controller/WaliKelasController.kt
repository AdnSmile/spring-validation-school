package com.example.springvalidationtest.controller

import com.example.springvalidationtest.dto.request.ReqWaliKelas
import com.example.springvalidationtest.dto.response.BaseResponse
import com.example.springvalidationtest.service.WaliKelasService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/api/sekolah/wali-kelas")
class WaliKelasController(
    val waliKelasService: WaliKelasService
) {

    @PostMapping
    fun addWaliKelas(@Valid @RequestBody waliKelas: ReqWaliKelas): ResponseEntity<BaseResponse<Any>> {

        val response = waliKelasService.saveWaliKelas(waliKelas)

        return ResponseEntity.ok(
            BaseResponse(
                status = "T",
                message = "Berhasil tambah data wali kelas",
                data = response
            )
        )
    }

    @GetMapping("/all")
    fun getAllWaliKelas(): ResponseEntity<BaseResponse<List<Any>>> {

        val response = waliKelasService.getAllWaliKelas()

        return ResponseEntity.ok(
            BaseResponse(
                status = "T",
                message = "Semua data wali kelas",
                data = response
            )
        )
    }

    @GetMapping
    fun getWaliKelas(@RequestParam("id") id: Int ): ResponseEntity<BaseResponse<Any>> {

        val response = waliKelasService.getWaliKelasById(id)

        return ResponseEntity.ok(
            BaseResponse(
                status = "T",
                message = "Tampil data wali kelas id $id",
                data = response
            )
        )
    }

    @PutMapping
    fun updateWaliKelas(@RequestParam("id") id: Int, @Valid @RequestBody waliKelas: ReqWaliKelas): ResponseEntity<BaseResponse<Any>> {

        val response = waliKelasService.updateWaliKelas(id, waliKelas)

        return ResponseEntity.ok(
            BaseResponse(
                status = "T",
                message = "Berhasil update data wali kelas",
                data = response
            )
        )
    }

    @DeleteMapping
    fun deleteWaliKelas(@RequestParam("id") id: Int): ResponseEntity<BaseResponse<Any>> {

        waliKelasService.deleteWaliKelas(id)

        return ResponseEntity.ok(
            BaseResponse(
                status = "T",
                message = "Berhasil hapus data wali kelas id $id",
                data = null
            )
        )
    }
}