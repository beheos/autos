package mx.beheos.autos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.beheos.autos.dao.ISucursalDao;
import mx.beheos.autos.entity.modelo.Sucursal;

@Service
public class SucursalServiceImpl implements ISucursalService {

	@Autowired
	ISucursalDao iSucursalDao;
	
	@Override
	public List<Sucursal> getSucursales() {
		return iSucursalDao.findAll();
	}

	@Override
	public Sucursal getSucursalBySucursal(String sucursal) {
		return iSucursalDao.findBySucursal(sucursal);
	}

}
