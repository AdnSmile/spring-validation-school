package com.example.springvalidationtest.controller

import com.example.springvalidationtest.dto.request.ReqKelas
import com.example.springvalidationtest.dto.request.ReqSiswa
import com.example.springvalidationtest.dto.response.BaseResponse
import com.example.springvalidationtest.service.SiswaService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/api/sekolah/siswa")
class SiswaController(
    val siswaService: SiswaService
) {

    @PostMapping
    fun addSiswa(@Valid @RequestBody siswa: ReqSiswa): ResponseEntity<BaseResponse<Any>> {

        val response = siswaService.saveSiswa(siswa)

        return ResponseEntity.ok(
            BaseResponse(
                status = "T",
                message = "Berhasil tambah data siswa",
                data = response
            )
        )
    }

    @GetMapping("/all")
    fun getAllSiswa(): ResponseEntity<BaseResponse<List<Any>>> {

        val response = siswaService.getAllSiswa()

        return ResponseEntity.ok(
            BaseResponse(
                status = "T",
                message = "Semua data siswa",
                data = response
            )
        )
    }

    @GetMapping
    fun getSiswa(@RequestParam("id") id: Int ): ResponseEntity<BaseResponse<Any>> {

        val response = siswaService.getSiswa(id)

        return ResponseEntity.ok(
            BaseResponse(
                status = "T",
                message = "Tampil data siswa id $id",
                data = response
            )
        )
    }

    @PutMapping
    fun updateSiswa(@RequestParam("id") id: Int, @Valid @RequestBody siswa: ReqSiswa): ResponseEntity<BaseResponse<Any>> {

        val response = siswaService.updateSiswa(id, siswa)

        return ResponseEntity.ok(
            BaseResponse(
                status = "T",
                message = "Berhasil update data siswa id $id",
                data = response
            )
        )
    }

    @DeleteMapping
    fun deleteSiswa(@RequestParam("id") id: Int): ResponseEntity<BaseResponse<Any>> {

        siswaService.delete(id)

        return ResponseEntity.ok(
            BaseResponse(
                status = "T",
                message = "Berhasil delete data siswa id $id",
                data = null
            )
        )
    }

}