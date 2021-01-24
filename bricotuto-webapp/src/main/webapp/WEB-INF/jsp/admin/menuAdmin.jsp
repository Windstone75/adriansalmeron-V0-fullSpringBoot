<!-- Font awesone (icone) -->
<script src='https://kit.fontawesome.com/a076d05399.js'></script>

<div class="sidebar">
	<div class="sidebar-menu-chapter">General</div>
	<a class="sidebar-menu-link" href="/admin"> <span class="menu-icon">
			<i class="fas fa-tachometer-alt"></i>
	</span> Dashboard
	</a>

	<div class="sidebar-menu-chapter">database</div>
	<button class="accordion sidebar-menu-link">
		<span class="menu-icon"> <i class="fas fa-table"></i>
		</span> Table
	</button>
	<div class="acordion-panel">
		<a class="sidebar-submenu-link" href="/admin/userTableAdmin">User</a> <a
			class="sidebar-submenu-link" href="/admin/roleTableAdmin">Role</a>
	</div>
</div>

<!-- Script accordion event-->
<script>
	var acc = document.getElementsByClassName("accordion");
	var i;
	for (i = 0; i < acc.length; i++) {
		acc[i].addEventListener("click", function() {
			this.classList.toggle("accordion-active");
			var panel = this.nextElementSibling;
			if (panel.style.display === "block") {
				panel.style.display = "none";
			} else {
				panel.style.display = "block";
			}
		});
	}
</script>


