package Operaciones;

import Modelos.Empresa;
import java.util.List;

public interface IOperacionEmpresa {
    void agregarEmpresa(Empresa empresa, List<Empresa> listaEmpresas);
    Empresa buscarEmpresaPorNit(String nit, List<Empresa> listaEmpresas);
    List<Empresa> obtenerTodasLasEmpresas(List<Empresa> listaEmpresas);
}