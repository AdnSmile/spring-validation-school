package com.example.springvalidationtest.service

import com.example.springvalidationtest.dto.request.ReqWaliKelas
import com.example.springvalidationtest.entity.WaliKelas

interface WaliKelasService {

    fun saveWaliKelas(waliKelas: ReqWaliKelas): WaliKelas

    fun getAllWaliKelas(): List<WaliKelas>

    fun getWaliKelasById(id: Int): WaliKelas

    fun updateWaliKelas(id: Int, waliKelas: ReqWaliKelas): WaliKelas

    fun deleteWaliKelas(id: Int)
}