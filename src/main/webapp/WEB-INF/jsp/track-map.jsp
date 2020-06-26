<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
	
	<div class="container">
		<table class="table table-striped">
			<caption>Hi,  You can track your friends here.</caption>
			<div id="map"></div>

			<script>
				mapboxgl.accessToken = 'pk.eyJ1IjoibWFwLWRldiIsImEiOiJjaXBmczZsY3YwMDFvc3htajJvMHptcnd2In0.XexHqpehDIOH2S28kXCCww';


				var map = new mapboxgl.Map({
					container: 'map', // container id
					style: 'mapbox://styles/mapbox/streets-v9', //stylesheet location
					center: [-79.204, 39.612], // starting position
					zoom: 5 // starting zoom
				});

				var biggerSmaller;

				map.on("load", function () {
					/* Image: An image is loaded and added to the map. */
					map.loadImage("https://i.imgur.com/MK4NUzI.png", function(error, image) {
						if (error) throw error;
						map.addImage("custom-marker", image);
						/* Style layer: A style layer ties together the source and image and specifies how they are displayed on the map. */
						map.addLayer({
							id: "markers",
							type: "symbol",
							/* Source: A data source specifies the geographic coordinate where the image marker gets placed. */
							source: {
								type: "geojson",
								data: {
									type: 'FeatureCollection',
									features: [
										{
											type: 'Feature',
											properties: {},
											geometry: {
												type: "Point",
												coordinates: [-79.204, 39.612]
											}
										},
										{
											type: 'Feature',
											properties: {},
											geometry: {
												type: "Point",
												coordinates: [-81.9506, 40.7202]
											}
										}
									]
								}
							},
							layout: {
								"icon-image": "custom-marker",
							}
						});
					});
				});

			</script>


		</table>
	</div>
<%@ include file="common/footer.jspf" %>