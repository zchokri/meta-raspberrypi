#
# This file was derived from the 'Hello World!' example recipe in the
# Yocto Project Development Manual.
#

DESCRIPTION = "Simple helloworld application"
SECTION = "examples"
DEPENDS = "gstreamer1.0 pkgconfig"
LICENSE = "CLOSED"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

SRCREV = "6834c99789e8ff2898c14fe2bb609ab54f13756b"

inherit pkgconfig
TARGET_CC_ARCH += "${LDFLAGS}"

SRC_URI = "https://github.com/zchokri/rtsp_client/archive/refs/tags/1.0.1.zip"
SRC_URI[sha256sum] = "a49eda1b1d0d4e7992723c101997074b334bea0419bc9e57606488a0a13d1a14"
S = "${WORKDIR}/rtsp_client-1.0.1"

do_compile() {
        oe_runmake all 'CC=${CXX}'
}
do_install() {
	install -d ${D}${bindir}/
	install -m 0755 ${S}/RTPStreaming ${D}${bindir}/
}

FILES_${PN} += " \
	${bindir}/ \
	"
