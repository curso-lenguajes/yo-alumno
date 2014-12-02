/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jc.elementos.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import org.codehaus.jackson.map.ObjectMapper;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author campitos
 */
public class DAOUsuarioImpl {
    
    
    public String obtenerTodos() throws Exception{
   SessionFactory factory= HIbernateUtilidades.getSessionFactory();
   Session sesion=    factory.openSession();
  Transaction tranza= sesion.beginTransaction();
 
Criteria cri=sesion.createCriteria(Usuario.class);


ArrayList<Usuario> usuarios= (ArrayList<Usuario>)cri.list();
Map<String, ArrayList<Usuario>> singletonMap =Collections.singletonMap("usuario", usuarios);

ObjectMapper mapper=new ObjectMapper();



  
  tranza.commit();
  sesion.close();
  
  return mapper.writeValueAsString(singletonMap);
    }
    
    public String obtenerUsuarioPorId(Integer id) throws Exception{
          SessionFactory factory= HIbernateUtilidades.getSessionFactory();
   Session sesion=    factory.openSession();
  Transaction tranza= sesion.beginTransaction();
 
Criteria cri=sesion.createCriteria(Usuario.class).add(Restrictions.idEq(id));


Usuario u=(Usuario)cri.uniqueResult();


ObjectMapper mapper=new ObjectMapper();


return mapper.writeValueAsString(u);
    }
    
    
       public String obtenerPorId(Integer id) throws Exception{
       SessionFactory factory= HIbernateUtilidades.getSessionFactory();
   Session sesion=    factory.openSession();
  Transaction tranza= sesion.beginTransaction();
 
Criteria cri=sesion.createCriteria(Usuario.class).add(Restrictions.idEq(id));
Usuario usuario= (Usuario)cri.uniqueResult();

ObjectMapper mapper=new ObjectMapper();



  
  tranza.commit();
  sesion.close();
  
  return mapper.writeValueAsString(usuario);
    }
       
       
       
    
}
