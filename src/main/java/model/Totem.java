package model;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.DiscoGrupo;
import com.github.britooo.looca.api.group.discos.Volume;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.rede.RedeInterface;
import com.github.britooo.looca.api.group.sistema.Sistema;

import java.util.*;

public class Totem {

        private Integer codigoTotem;
        private final String macAddress;
        Looca looca = new Looca();
        private final Sistema sistema;
        private final Memoria memoria;
        private final Processador processador;
        private final DiscoGrupo grupoDisco;
        private final List<RedeInterface> interfaces;

        public Totem(Integer codigoTotem) {
            this.sistema = this.looca.getSistema();
            this.memoria = this.looca.getMemoria();
            this.processador = this.looca.getProcessador();
            this.grupoDisco = this.looca.getGrupoDeDiscos();
            this.interfaces = this.looca.getRede().getGrupoDeInterfaces().getInterfaces();
            this.codigoTotem = codigoTotem;
            this.macAddress = this.setMacAAdress();
        }

        public Totem() {
            this.sistema = this.looca.getSistema();
            this.memoria = this.looca.getMemoria();
            this.processador = this.looca.getProcessador();
            this.grupoDisco = this.looca.getGrupoDeDiscos();
            this.interfaces = this.looca.getRede().getGrupoDeInterfaces().getInterfaces();
            this.codigoTotem = 0;
            this.macAddress = this.setMacAAdress();
        }

        public String setMacAAdress() {
            List<String> listaMacAAdress = new ArrayList();
            Iterator var2 = this.interfaces.iterator();

            while(var2.hasNext()) {
                RedeInterface anInterface = (RedeInterface)var2.next();
                if (!anInterface.getEnderecoIpv4().isEmpty()) {
                    listaMacAAdress.add(anInterface.getEnderecoMac());
                }
            }

            return (String)listaMacAAdress.get(1);
        }

        public Integer getCodigoTotem() {
            return this.codigoTotem;
        }

        public void setCodigoTotem(Integer codigoTotem) {
            this.codigoTotem = codigoTotem;
        }

        public String getMacAddress() {
            return this.macAddress;
        }

        public String getSistemaOperacional() {
            return this.sistema.getSistemaOperacional();
        }

        public Long getSistemaTempoDeAtividade() {
            return this.sistema.getTempoDeAtividade();
        }

        public String getSistemaFabricante() {
            return this.sistema.getFabricante();
        }

        public Memoria getMemoria() {
            return this.memoria;
        }

        public String getMemoriaNome() {
            return "";
        }

        public Long getMemoriaTotal() {
            return this.memoria.getTotal();
        }

        public Long getMemoriaDisponivel() {
            return this.memoria.getDisponivel();
        }

        public Long getMemoriaEmUso() {
            return this.memoria.getEmUso();
        }

        public Long getPorcentagemUsoMemoria() {
            Long emUso = this.memoria.getTotal() - this.memoria.getDisponivel();
            return emUso * 100L / this.memoria.getTotal();
        }

        public Processador getProcessador() {
            return this.processador;
        }

        public String getProcessadorNome() {
            return this.processador.getNome();
        }

        public String getProcessadorFabricante() {
            return this.processador.getFabricante();
        }

        public Integer getProcessadorCpusFisicas() {
            return this.processador.getNumeroCpusFisicas();
        }

        public Integer getProcessadorCpusLogicas() {
            return this.processador.getNumeroCpusLogicas();
        }

        public Long getProcessadorFrequencia() {
            return this.processador.getFrequencia();
        }

        public Long getProcessadorUso() {
            return this.processador.getUso().longValue();
        }

        public DiscoGrupo getGrupoDisco() {
            return this.grupoDisco;
        }

        public List<String> getModelosDiscos() {
            List<String> modelosDiscos = new ArrayList();
            Iterator var2 = this.grupoDisco.getDiscos().iterator();

            while(var2.hasNext()) {
                Disco disco = (Disco)var2.next();
                modelosDiscos.add(disco.getModelo());
            }

            return modelosDiscos;
        }

        public Integer getQuantidadeDeDiscos() {
            return this.grupoDisco.getQuantidadeDeDiscos();
        }

        public Map<String, Long> getPorcentagemUsoVolumes() {
            Map<String, Long> mapaPorcentagemUsoVolumes = new TreeMap();
            Iterator var2 = this.grupoDisco.getVolumes().iterator();

            while(var2.hasNext()) {
                Volume volume = (Volume)var2.next();
                Long emUso = volume.getTotal() - volume.getDisponivel();
                Long porcentagemVolumeUso = emUso * 100L / volume.getTotal();
                mapaPorcentagemUsoVolumes.put(volume.getNome(), porcentagemVolumeUso);
            }

            return mapaPorcentagemUsoVolumes;
        }

        public String toString() {
            return "\nCódigo do totem: %s\nMacAddress do totem: %s\n".formatted(this.codigoTotem, this.macAddress);
        }
    }

