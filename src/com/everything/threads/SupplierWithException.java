package com.everything.threads;

/**
 * Created by mcalancea
 * Date: 05 Jun 2018
 * Time: 12:21
 */
public interface SupplierWithException<R> {
    R get() throws Exception;
}
