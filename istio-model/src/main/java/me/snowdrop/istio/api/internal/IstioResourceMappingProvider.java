/**
 * Copyright 2018 Red Hat, Inc. and/or its affiliates.
 * <p>
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package me.snowdrop.istio.api.internal;

import java.util.Map;
import java.util.stream.Collectors;

import io.fabric8.kubernetes.api.KubernetesResourceMappingProvider;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import me.snowdrop.istio.api.model.IstioResource;

/**
 * @author <a href="claprun@redhat.com">Christophe Laprun</a>
 */
public class IstioResourceMappingProvider implements KubernetesResourceMappingProvider {
    private final static Map<String, Class<? extends KubernetesResource>> mappings =
            IstioSpecRegistry.getKnownKinds().stream().collect(Collectors.toMap(kind -> kind, kind -> IstioResource.class));

    @Override
    public Map<String, Class<? extends KubernetesResource>> getMappings() {
        return mappings;
    }
}
