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

RDEPENDS_${PN} += "bash initscripts"

INITSCRIPT_NAME = "rtsp-client"
INITSCRIPT_PARAMS = "defaults"
 
TARGET_CC_ARCH += "${LDFLAGS}"

SRC_URI = "https://github.com/zchokri/rtsp_client/archive/refs/tags/1.0.2.zip"
SRC_URI[sha256sum] = "c2aa1ef0d44ff4d57260802e73de3dc642a02496be2f0993b4f8afada5b93aa4"
S = "${WORKDIR}/rtsp_client-1.0.2"

do_compile() {
        oe_runmake all 'CC=${CXX}'
}
do_install() {
	install -d ${D}${bindir}/
	install -m 0755 ${S}/RTPStreaming ${D}${bindir}/
	install -d 644  ${D}${sysconfdir}/init.d
    install -m 0755 ${S}/start_rtsp_client.sh ${D}${sysconfdir}/init.d/start_rtsp_client.sh
}

FILES_${PN} += " \
	${bindir}/ \
	${sysconfdir}/init.d \
	"
