/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jc.elementos.controller;

import com.jc.elementos.model.DAOUsuarioImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class ControladorUsuario {
    
    @RequestMapping(value="/user", method=RequestMethod.GET, headers={"Accept=Application/json"})
    public @ResponseBody String hola2()throws Exception{
    DAOUsuarioImpl d=new DAOUsuarioImpl();
    
   String hola= d.obtenerTodos();
        return hola;
    }
    
}
