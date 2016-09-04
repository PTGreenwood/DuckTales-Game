package uq.deco2800.ducktales.rendering.managers;

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
public class AgentEntityInfoManager {
    /** The instance and its getter method of this class */
    private static final AgentEntityInfoManager INSTANCE = new AgentEntityInfoManager();
    public static AgentEntityInfoManager getInstance() { return INSTANCE; }

    /** REGISTERED AGENT TYPES */
    private final ResourceType[] agentTypes = {
        SHEEP
    };

    /** The variable containing the information of each agent type */
    private ArrayList<ResourceType> agentRenderingInfo;

    private AgentEntityInfoManager() {
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
