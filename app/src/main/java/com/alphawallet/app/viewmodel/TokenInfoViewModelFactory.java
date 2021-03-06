package com.alphawallet.app.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.alphawallet.app.service.AssetDefinitionService;
import com.alphawallet.app.service.TokensService;

import io.reactivex.annotations.NonNull;

public class TokenInfoViewModelFactory implements ViewModelProvider.Factory {

    private final AssetDefinitionService assetDefinitionService;
    private final TokensService tokensService;

    public TokenInfoViewModelFactory(AssetDefinitionService assetDefinitionService,
                                     TokensService tokensService)
    {
        this.assetDefinitionService = assetDefinitionService;
        this.tokensService = tokensService;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass)
    {
        return (T) new TokenInfoViewModel(assetDefinitionService, tokensService);
    }
}
