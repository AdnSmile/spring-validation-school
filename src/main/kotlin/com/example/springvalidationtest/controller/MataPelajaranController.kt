package com.example.springvalidationtest.controller

import com.example.springvalidationtest.dto.request.ReqMataPelajaran
import com.example.springvalidationtest.dto.response.BaseResponse
import com.example.springvalidationtest.service.MataPelajaranService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/api/sekolah/mapel")
class MataPelajaranController(
    val mapelService: MataPelajaranService
) {

    @PostMapping
    fun addMataPelajaran(@Valid @RequestBody mapel: ReqMataPelajaran): ResponseEntity<BaseResponse<Any>> {

        val response = mapelService.saveMapel(mapel)

        return ResponseEntity.ok(
            BaseResponse(
                status = "T",
                message = "Berhasil tambah data Mata Pelajaran",
                data = response
            )
        )
    }

    @PutMapping
    fun updateMapel(@RequestParam("id") id: Int, @RequestBody newMapel: ReqMataPelajaran): ResponseEntity<BaseResponse<Any>> {

        val response = mapelService.updateMapel(id, newMapel)

        return ResponseEntity.ok(
            BaseResponse(
                status = "T",
                message = "Berhasil update data id $id Mata Pelajaran",
                data = response
            )
        )
    }

    @GetMapping("/all")
    fun getAllMapel(): ResponseEntity<BaseResponse<List<Any>>> {

        val response = mapelService.getAllMapel()

        return ResponseEntity.ok(
            BaseResponse(
                status = "T",
                message = "Semua data Mata Pelajaran",
                data = response
            )
        )
    }

    @GetMapping
    fun getMapel(@RequestParam("id") id: Int): ResponseEntity<BaseResponse<Any>> {

        val response = mapelService.getMapelById(id)

        return ResponseEntity.ok(
            BaseResponse(
                status = "T",
                message = "Tampil data Mata Pelajaran id $id",
                data = response
            )
        )
    }

    @DeleteMapping
    fun deleteMapel(@RequestParam("id") id: Int): ResponseEntity<BaseResponse<Any>> {

        mapelService.deleteMapel(id)

        return ResponseEntity.ok(
            BaseResponse(
                status = "T",
                message = "Berhasil hapus data Mata Pelajaran id $id",
                data = null
            )
        )
    }
}