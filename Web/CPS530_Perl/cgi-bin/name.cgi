#!/usr/bin/perl
use CGI ':standard';
print "Content-type: text/html\n\n";

$name = param ('name');
print "Hello $name";
