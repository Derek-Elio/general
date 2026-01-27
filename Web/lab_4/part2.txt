#!/usr/bin/perl
#!C:\Perl\bin\perl.exe
use CGI':standard';
use CGI::Carp 
use warnings;
use strict;
use scalar::Util qw(looks_like_number);
print "Content-type: text/html\n\n";


if ((looks_like_number($phonenumber)) && (length($phonenumber)==10){
    print "<p>Phone number valid!</p>"
}else{
    print "<p>Error: Invalid Phone Number</p>"
}

if (length($postalcode)==6){
    print "<p>Postal Code valid!</p>"
    }else{
        print "<p>Error: Invalid Postal Code</p>"
    }