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
					center: [-74.50, 40], // starting position
					zoom: 9 // starting zoom
				});

				var biggerSmaller;

				map.on('load', function() {
					var mapCanvas = document.getElementsByClassName('mapboxgl-canvas')[0];
					var mapDiv = document.getElementById('map');
					var breakButton = document.getElementById('resizeDiv');
					var fixButton = document.getElementById('resizeMap');

					breakButton.onclick = function() {
						if (biggerSmaller !== 'smaller') {
							mapDiv.style.width = '50%';
							mapCanvas.style.width = '100%';
							biggerSmaller = 'smaller';
						} else {
							mapDiv.style.width = '150%';
							mapCanvas.style.width = '100%';
							biggerSmaller = 'bigger';
						}
					}

					fixButton.onclick = function() {
						map.resize();
					}

				});

			</script>


		</table>
	</div>
<%@ include file="common/footer.jspf" %>