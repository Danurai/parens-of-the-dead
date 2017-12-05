(defproject parens-of-the-dead "0.1.0-SNAPSHOT"
	:description	"A series of zombie-themed games written with Clojure and Clojurescript."
	:url "https://danurai.github.io/parens-of-the-dead"
	:license {:name "GNU General Public License"
				:url "http://www.gnu.org/licenses/gpl.html"}
	:jvm-opts ["-XX:MaxPermSize=256m"]
	:dependencies	[[org.clojure/clojure "1.8.0"]]
	:profiles	{:dev	{:plugins []
						 :dependencies []
						 :source-paths ["dev"]}})