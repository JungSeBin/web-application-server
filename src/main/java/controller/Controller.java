package controller;

import http.HttpRequest;
import http.HttpResponse;


abstract public interface Controller {
	void service(HttpRequest request, HttpResponse response);
}