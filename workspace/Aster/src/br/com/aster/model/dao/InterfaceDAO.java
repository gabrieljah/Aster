package br.com.aster.model.dao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;

public abstract interface InterfaceDAO<T>
{
  public abstract void save(T paramT);

  public abstract void update(T paramT);

  public abstract void remove(T paramT);

  public abstract void merge(T paramT);

  public abstract T getEntity(Serializable paramSerializable);

  public abstract T getEntityByDetachedCriteria(DetachedCriteria paramDetachedCriteria);

  public abstract List<T> getEntities();

  public abstract List<T> getListByDetachedCriteria(DetachedCriteria paramDetachedCriteria);

  public abstract List<T> getListByCriteriaOrderAsc(String paramString);

  public abstract List<T> getListByCriteriaOrderDesc(String paramString);

  public abstract List<T> getListbyCriteriaDetail(String paramString);

  public abstract List<T> getListbyCriteriaStatusEntrada(String paramString);

  public abstract List<T> getListbyCriteriaBetween(Date paramDate1, Date paramDate2, String paramString1, String paramString2, Long paramLong1, Long paramLong2);

  public abstract List<T> getListbyCriteriaStatusSaida(String paramString);

  public abstract List<T> getListbyCriteriaCompleteCargo(String paramString);
}

/* Location:           C:\Users\gabriel\Documents\NetBeansProjects\WEB-INF\classes\
 * Qualified Name:     br.com.aster.model.dao.InterfaceDAO
 * JD-Core Version:    0.6.0
 */