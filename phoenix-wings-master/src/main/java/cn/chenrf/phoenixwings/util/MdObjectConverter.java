package cn.chenrf.phoenixwings.util;

public interface MdObjectConverter<T, R> {

  R from(T t);
}
