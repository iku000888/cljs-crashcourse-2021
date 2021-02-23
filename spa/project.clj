(defproject my-awesome-project "0.1.0"
  :source-paths ["src"]
  :repl-options
  {:nrepl-middleware
   [shadow.cljs.devtools.server.nrepl/middleware]}
  :dependencies [[thheller/shadow-cljs "2.11.18"]
                 [reagent "1.0.0"]
                 [cljs-ajax "0.8.1"]])
