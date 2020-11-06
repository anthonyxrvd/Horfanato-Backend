package com.clases.springboot.app.models.service;

import com.clases.springboot.app.models.dao.Login;
import com.clases.springboot.app.models.dao.User;

public interface ILoginService {
	User validar(Login login);
}
