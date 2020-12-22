
Vagrant.configure("2") do |config|
  config.vm.box = "hashicorp/bionic64"
  config.vm.network "forwarded_port", guest: 5050, host: 5050
  config.vm.provision :shell, path: "docker.sh"
  config.vm.provision :shell, path: "docker-compose.sh"
end
