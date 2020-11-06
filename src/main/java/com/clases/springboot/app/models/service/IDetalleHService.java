package com.clases.springboot.app.models.service;

import com.clases.springboot.app.models.entity.DetalleHuerfano;

public interface IDetalleHService {
void agregar(DetalleHuerfano detalle);
void eliminar(int id);
}
