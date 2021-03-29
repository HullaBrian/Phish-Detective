# Phish Detective
Phish Detective is a command line application built to detect a phishing site from two url's
# How does it work?
A simple algorithm is used in order to determine whether a url is possibly trying to phish or not
  1. Attain the domain name and protocol of the url
  2. If the the domain name and protocol are the same then it is not a phishing site. If not, the checked url is most likely a phishing url.

# How to work it?
In the command prompt simply type
  "pd --host host url --check url to check"
Then the out put will look like:
  Host url ~ host url
  Url in question ~ checked url

  Host domain ~ host domain
  Host protocol ~ host protocol
  Unidentified domain ~ checked domain
  Unidentified protocol ~ checked protocol

  WARNING: Identified host url as a possible phishing site
