/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./src/**/*.{html,ts}",
],
  theme: {
    extend: {
		backgroundImage: {
			'home_img1': "url('assets/login_img1.png')",
			'home_img2': "url('assets/login_img2.png')",
			'logo': "url('assets/logo.png')"
		}
	},
  },
  darkMode: 'class',
  plugins: [],
}

