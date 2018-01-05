(defproject parens-of-the-dead "0.1.0-SNAPSHOT"
	:description	"A series of zombie-themed games written with Clojure and Clojurescript."
	:url "https://danurai.github.io/parens-of-the-dead"
	:license {:name "GNU General Public License"
				:url "http://www.gnu.org/licenses/gpl.html"}
	;;:jvm-opts ["-XX:MaxPermSize=256m"]
	:main undead.system
	:dependencies	[[org.clojure/clojure "1.8.0"]
                [org.clojure/clojurescript "1.9.946"]
				    [http-kit "2.2.0"]
                [com.stuartsierra/component "0.3.2"]
					 [compojure "1.6.0"]
					 [reagent "0.7.0"]
					 ;;[expectations "2.2.0-rc3"]
					 [jarohen/chord "0.8.1"]
					 [org.clojure/core.async "0.3.465"]
					 ]
	:profiles {:dev {:plugins [[lein-cljsbuild "1.1.7"]
                           [lein-figwheel "0.5.14"]
									[lein-autoexpect "1.9.0"]]
                   :dependencies [[reloaded.repl "0.2.4"]
                                [expectations "2.2.0-rc3"]]
                   :source-paths ["dev"]
                   :cljsbuild {:builds [{:id cljsbuild1
													:source-paths ["src" "dev"]
                                       :figwheel true
                                       :compiler {:output-to "target/classes/public/app.js"
                                                 :output-dir "target/classes/public/out"
																 :main "undead.client"
                                                 :asset-path "/out"
                                                 :optimizations :none
                                                 :recompile-dependents true
                                                 :source-map true}}]}}})