SUMMARY = "the implementation of SOME/IP"
SECTION = "base"
LICENSE = "CLOSED"

DEPENDS = "boost"

#SRCREV = "13f9c89ced6ffaeb1faf485152e27e1f40d234cd"
SRC_URI = "git://github.com/COVESA/vsomeip.git;protocol=https;tag=3.1.20.3 \
"

SRC_URI[sha256sum] = "909ef4be88f6eb32d07412529ca6f59accb0d8a7c4e787b7aa994354e4e98a62"

S = "${WORKDIR}/git"

inherit cmake lib_package gitpkgv

EXTRA_OECMAKE += "-DENABLE_SIGNAL_HANDLING=1"

FILES_${PN} = "  /usr/etc \
  /usr/include \
  /usr/lib \
  /usr/lib/libvsomeip3-sd.so \
  /usr/lib/libvsomeip3-sd.so.3 \
  /usr/lib/libvsomeip3-cfg.so.3.1.20 \
  /usr/lib/libvsomeip3-e2e.so.3.1.20 \
  /usr/lib/libvsomeip3.so \
  /usr/lib/libvsomeip3-e2e.so.3 \
  /usr/lib/libvsomeip3-sd.so.3.1.20 \
  /usr/lib/libvsomeip3-cfg.so \
  /usr/lib/libvsomeip3-cfg.so.3 \
  /usr/lib/libvsomeip3.so.3.1.20 \
  /usr/lib/libvsomeip3-e2e.so \
  /usr/lib/libvsomeip3.so.3 \
"
