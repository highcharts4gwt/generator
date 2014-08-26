GwtHighcharts
=============

This project is about creating an auto-generated GWT highcharts wrapper.

To know more about Highcharts please have a look to [the official web page](http://www.highcharts.com/products/highcharts)

This project has been created as an alternative to moxie highcharts wrapper [Sourceforge sources](http://sourceforge.net/projects/gwt-highcharts/)  [http://www.moxiegroup.com/moxieapps/gwt-highcharts/](http://www.moxiegroup.com/moxieapps/gwt-highcharts/)

#Why this wrapper ?

* Moxie wrapper does not seem to be maintained anymore (last commit on August 2013)
* I disagree with some of the design choices in moxie wrapper
  * Mix between view and model that prevent an easy mvp implementation
* I would like to have a wrapper that can be generated automatically from highcharts [options dump](http://api.highcharts.com/highcharts/option/dump.json)

