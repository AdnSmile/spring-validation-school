package com.example.springvalidationtest.controller

import com.example.springvalidationtest.dto.request.ReqKelas
import com.example.springvalidationtest.dto.response.BaseResponse
import com.example.springvalidationtest.service.KelasService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/api/sekolah/kelas")
class KelasController(
    val kelasService: KelasService
) {

    @PostMapping
    fun addKelas(@Valid @RequestBody kelas: ReqKelas): ResponseEntity<BaseResponse<Any>> {

        val response = kelasService.saveKelas(kelas)

        return ResponseEntity.ok(
            BaseResponse(
                status = "T",
                message = "Berhasil tambah data kelas",
                data = response
            )
        )
    }

    @GetMapping("/all")
    fun getAllKelas(): ResponseEntity<BaseResponse<List<Any>>> {

        val response = kelasService.getAllKelas()

        return ResponseEntity.ok(
            BaseResponse(
                status = "T",
                message = "Semua data kelas",
                data = response
            )
        )
    }

    @GetMapping
    fun getKelas(@RequestParam("id") id: Int ): ResponseEntity<BaseResponse<Any>> {

        val response = kelasService.getKelasById(id)

        return ResponseEntity.ok(
            BaseResponse(
                status = "T",
                message = "Tampil data kelas id $id",
                data = response
            )
        )
    }

    @PutMapping
    fun updateKelas(@RequestParam("id") id: Int, @Valid @RequestBody kelas: ReqKelas): ResponseEntity<BaseResponse<Any>> {

        val response = kelasService.updateKelas(id, kelas)

        return ResponseEntity.ok(
            BaseResponse(
                status = "T",
                message = "Berhasil update data kelas id $id",
                data = response
            )
        )
    }

    @DeleteMapping
    fun deleteKelas(@RequestParam("id") id: Int): ResponseEntity<BaseResponse<Any>> {

        kelasService.deleteKelasById(id)

        return ResponseEntity.ok(
            BaseResponse(
                status = "T",
                message = "Berhasil delete data kelas id $id",
                data = null
            )
        )
    }
}