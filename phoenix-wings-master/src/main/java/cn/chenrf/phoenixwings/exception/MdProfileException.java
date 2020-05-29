package cn.chenrf.phoenixwings.exception;

import cn.chenrf.pyramid.exception.GenericException;

public class MdProfileException extends GenericException {

  public MdProfileException(String resultCode, String resultMsg) {
    super(resultCode, resultMsg);
  }

  public MdProfileException(String resultCode, String resultMsg, Throwable throwable) {
    super(resultCode, resultMsg, throwable);
  }
}
