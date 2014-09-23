highcharts4gwt
=============

[![Build Status](https://travis-ci.org/highcharts4gwt/highcharts4gwt.svg?branch=master)](https://travis-ci.org/highcharts4gwt/highcharts4gwt) [![Coverage Status](https://coveralls.io/repos/highcharts4gwt/highcharts4gwt/badge.png)](https://coveralls.io/r/highcharts4gwt/highcharts4gwt)

## Status
v0 still in development.

First rendering of a chart achieved by using the generated API !!!

Lot of work to do but a big first step accomplished :)

Here is the result inside the test project application: 

![First Chart](./ScreenShot.png)



If you want to test simply run highcharts4gwt as a Java application it will generate the API code.

## Description
The goal of this project is to create an "auto-generated" GWT highcharts wrapper.

To know more about Highcharts please have a look to [the official web page](http://www.highcharts.com/products/highcharts)

This project has been created as an alternative to the very good [Moxiegroup](http://www.moxiegroup.com/) highcharts wrapper [http://www.moxiegroup.com/moxieapps/gwt-highcharts/](http://www.moxiegroup.com/moxieapps/gwt-highcharts/), sources of that project can be found on [sourceforge](http://sourceforge.net/projects/gwt-highcharts/) 

#Why this wrapper ?

* Moxie wrapper does not seem to be maintained anymore (last commit on August 2013)
* I disagree with some of the design choices in moxie wrapper (mix between view and model that prevent an easy mvp implementation and testing)
* I would like to have a wrapper that can be generated automatically from highcharts [options dump](http://api.highcharts.com/highcharts/option/dump.json) to keep up to date easily with api changes

To know more about this project please go to the [project website](https://gwthighcharts.github.io/)

#What should the generated code look like ?

* Fluent api
* As close as possible to the Javascript syntax
* As much as possible @JsInterface and @JsProperty ready [blog post](http://ronanquillevere.github.io/2014/02/02/GWT-futur-javascript-interop.html#.U_7f6zK1Z5I)
* Model (Options etc...) separated from Widget (The panel displaying the chart in GWT)
* Junit testable
  * Being able to use DI to choose between real JSO or Mock for tests.
