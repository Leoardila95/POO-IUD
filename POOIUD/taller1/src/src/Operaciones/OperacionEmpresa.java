package Operaciones;

import Modelos.Empresa;
import java.util.List;

public class OperacionEmpresa implements IOperacionEmpresa {

    @Override
    public void agregarEmpresa(Empresa empresa, List<Empresa> listaEmpresas) {
        if (empresa != null && !listaEmpresas.contains(empresa)) {
            listaEmpresas.add(empresa);
            System.out.println("Empresa " + empresa.getNombre() + " agregada con éxito.");
        } else {
            System.out.println("No se pudo agregar la empresa. Ya existe o es nula.");
        }
    }

    @Override
    public Empresa buscarEmpresaPorNit(String nit, List<Empresa> listaEmpresas) {
        for (Empresa emp : listaEmpresas) {
            if (emp.getNit().equals(nit)) {
                return emp;
            }
        }
        return null;
    }

    @Override
    public List<Empresa> obtenerTodasLasEmpresas(List<Empresa> listaEmpresas) {
        return listaEmpresas;
    }
}
