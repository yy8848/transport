function open(id, url) {
	if (id && id.indexOf('.html')) {
		mui.openWindow({
						id: id,
						url: this.href,
						waiting: {
							autoShow: false
						}
					});
	}
}
