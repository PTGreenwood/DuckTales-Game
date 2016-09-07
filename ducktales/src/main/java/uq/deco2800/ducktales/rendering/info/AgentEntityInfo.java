package uq.deco2800.ducktales.rendering.info;

import uq.deco2800.ducktales.resources.ResourceType;

import java.util.ArrayList;

import static uq.deco2800.ducktales.resources.ResourceType.*;

/**
 * This class is a singleton that manages the rendering information for each type
 * of agent entity
 *
 * Created on 5/09/2016.
 * @author khoiphan21
 */
public class AgentEntityInfo {
    /** The instance and its getter method of this class */
    private static final AgentEntityInfo INSTANCE = new AgentEntityInfo();

    public static AgentEntityInfo getInstance() { return INSTANCE; }

    /** REGISTERED AGENT TYPES */
    private final ResourceType[] agentTypes = {
        SHEEP, COW_FRONT_RIGHT, DUCK_1_1
    };

    /** The variable containing the information of each agent type */
    private ArrayList<ResourceType> agentRenderingInfo;

    private AgentEntityInfo() {
        agentRenderingInfo = new ArrayList<>();

        // register all agent types
        for (int i = 0; i < agentTypes.length; i++) {
            agentRenderingInfo.add(agentTypes[i]);
        }
    }

    public boolean containEntity(ResourceType agentType) {
        return agentRenderingInfo.contains(agentType);
    }
}
